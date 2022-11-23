package com.atguigu.es.test;

import net.sf.jsqlparser.statement.create.index.CreateIndex;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class ESTest_Index_Create {

    public static void main(String[] args) throws IOException {

        //创建ES客户端；
        RestHighLevelClient esClient  =  new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );


        //创建索引：

        CreateIndexRequest createrequest = new CreateIndexRequest("user");

        CreateIndexResponse response = esClient.indices().create(createrequest, RequestOptions.DEFAULT);


        //响应状态
        boolean acknowledged = response.isAcknowledged();

        System.out.println("索引操作："+acknowledged);
        //关闭ES客户端

        esClient.close();


    }

}
