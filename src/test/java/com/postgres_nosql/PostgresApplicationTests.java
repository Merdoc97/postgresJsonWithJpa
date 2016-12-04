package com.postgres_nosql;

import com.postgres_nosql.model.ProductStatistic;
import com.postgres_nosql.model.UserStatistic;
import com.postgres_nosql.model.info.ProductInfo;
import com.postgres_nosql.model.info.UserInfo;
import com.postgres_nosql.repository.CommonModelRepository;
import com.postgres_nosql.repository.ProductStatisticRepository;
import com.postgres_nosql.repository.UserStatisticRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PostgresApplication.class)
public class PostgresApplicationTests {

    @Autowired
    private ProductStatisticRepository productStatisticRepository;
    @Autowired
    private UserStatisticRepository userStatisticRepository;
    @Autowired
    private CommonModelRepository commonModelRepository;
    @Before
    public void setUp() {
        commonModelRepository.deleteAll();
        List<UserStatistic>userStatisticList= Arrays.asList(
                new UserStatistic(new UserInfo(new Date(),"login","test@gmail.com")),
                new UserStatistic(new UserInfo(new Date(),"second user","test2@gmail.com")));
        List<ProductStatistic>productStatisticList=Arrays.asList(
                new ProductStatistic(new ProductInfo("first product",new Date(),"in stock"))
        );
        commonModelRepository.save(userStatisticList);
        commonModelRepository.save(productStatisticList);
    }

    @Test
    public void productStatisticTest() {
        List<ProductStatistic> productStatisticList=productStatisticRepository.findAll();
        Assert.assertThat("check size",productStatisticList, Matchers.hasSize(1));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void checkConstrainProductTest(){
        commonModelRepository.save(new ProductStatistic(new ProductInfo("first product",new Date(),"in stock")));
    }

    //be careful for update.
    //if you want to user update in json type as entity you should override equals and hashcode for all fields
    @Test
    public void updateTest(){
         ProductStatistic productStatistic=productStatisticRepository.findByProductName("first product");
        ProductInfo info=productStatistic.getInfo();
        info.setProductAdditionalInfo("not in stock");
        productStatistic.setInfo(info);
        productStatisticRepository.save(productStatistic);
        productStatistic=productStatisticRepository.findByProductName("first product");
        Assert.assertThat(productStatistic.getInfo().getProductAdditionalInfo(),Matchers.is("not in stock"));
    }
    @Test
    public void getUserByEmail(){
        Assert.assertNotNull(userStatisticRepository.getUserByEmail("test@gmail.com"));
    }
    //benchmark test insert 10000rows
    @Test
    @Ignore
    public void benchmarkInsertTest() throws InterruptedException {
        commonModelRepository.deleteAll();
        List<ProductStatistic>list=new ArrayList<>();
        for (int i=0;i<10000;i++)list.add( new ProductStatistic(new ProductInfo("first product"+i,new Date(),"in stock")));
        long startTime=System.currentTimeMillis();
        commonModelRepository.save(list);

        long endTime=System.currentTimeMillis();
        long resInSec=(endTime-startTime)/1000;
        System.out.println("result is "+resInSec+" sec");
        //----------select by index time
        startTime=System.currentTimeMillis();
        productStatisticRepository.findByProductName("first product"+4000);
        endTime=System.currentTimeMillis();
        resInSec=(endTime-startTime)/1000;
        System.out.println("select by jsonIndex time "+resInSec+" sec");

        //----------select all
        startTime=System.currentTimeMillis();
        List<ProductStatistic>productStatisticList=productStatisticRepository.findAll();
        endTime=System.currentTimeMillis();
        resInSec=(endTime-startTime)/1000;
        System.out.println("select all time "+resInSec+" sec");
    }
}
