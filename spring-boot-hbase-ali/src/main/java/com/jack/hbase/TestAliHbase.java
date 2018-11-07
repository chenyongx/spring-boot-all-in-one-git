package com.jack.hbase;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * @author yangyueming
 */
@Slf4j
public class TestAliHbase {
    private static final String TABLE_NAME = "test4";
    private static final String CF_DEFAULT = "cf";
    private static final byte[] QUALIFIER = "a".getBytes();
    private static final byte[] ROWKEY = "row1".getBytes();
    public static void main(String[] args) {
        Configuration config = HBaseConfiguration.create();
//        String zkAddress = "hb-bp1f5xxxx48a0r17i-001.hbase.rds.aliyuncs.com:2181,hb-bp1f5xxxx48a0r17i-002.hbase.rds.aliyuncs.com:2181,hb-bp1f5xxxx48a0r17i-003.hbase.rds.aliyuncs.com:2181";
        String zkAddress = "hb-proxy-pub-wz9e709sr8mjm6xrd-001.hbase.rds.aliyuncs.com:2181";
        config.set(HConstants.ZOOKEEPER_QUORUM, zkAddress);
        Connection connection = null;
        try {
            connection = ConnectionFactory.createConnection(config);
            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(TABLE_NAME));
            tableDescriptor.addFamily(new HColumnDescriptor(CF_DEFAULT));
            log.info("Creating table. ");
            Admin admin = connection.getAdmin();
            admin.createTable(tableDescriptor);
            log.info(" Done.");
            try (Table table = connection.getTable(TableName.valueOf(TABLE_NAME))) {
                Put put = new Put(ROWKEY);
                put.addColumn(CF_DEFAULT.getBytes(), QUALIFIER, "this is value".getBytes());
                table.put(put);
                Get get = new Get(ROWKEY);
                Result result = table.get(get);
                byte[] b = result.getValue(CF_DEFAULT.getBytes(), QUALIFIER);  // returns current version of value
                log.info(new String(b));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
