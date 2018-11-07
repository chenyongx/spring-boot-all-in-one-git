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
public class HandlerHBase {
    private static final String TABLE_NAME = "table11";
    private static final String ZK_ADDRESS = "hb-proxy-pub-wz9e709sr8mjm6xrd-001.hbase.rds.aliyuncs.com:2181";

    public static void main(String[] args) throws IOException {
        putData("userId-1".getBytes(), "routeId-1".getBytes(), "drivingSpeed".getBytes(), "500km/h".getBytes());
        log.info("=====================插入完毕==============");
        log.info(getData("userId-1".getBytes(), "routeId-1".getBytes(), "drivingSpeed".getBytes()));
    }

    public static void putData(byte[] rowKey, byte[] family, byte[] column, byte[] value) throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set(HConstants.ZOOKEEPER_QUORUM, ZK_ADDRESS);
        TableName tableName = TableName.valueOf(TABLE_NAME);
        try (Connection connection = ConnectionFactory.createConnection(config); Table table = connection.getTable(tableName);) {
            HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
            hTableDescriptor.addFamily(new HColumnDescriptor(family));
            Admin admin = connection.getAdmin();
            if (!admin.tableExists(tableName)) {
                admin.createTable(hTableDescriptor);
            }
            Put put = new Put(rowKey);
            put.addColumn(family, column, value);
            table.put(put);
        }
    }

    public static String getData(byte[] rowKey, byte[] family, byte[] column) throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set(HConstants.ZOOKEEPER_QUORUM, ZK_ADDRESS);
        TableName tableName = TableName.valueOf(TABLE_NAME);
        try (Connection connection = ConnectionFactory.createConnection(config); Table table = connection.getTable(tableName);) {
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
            tableDescriptor.addFamily(new HColumnDescriptor(family));
            Admin admin = connection.getAdmin();
            if (!admin.tableExists(tableName)) {
                admin.createTable(tableDescriptor);
            }
            Get get = new Get(rowKey);
            Result result = table.get(get);
            byte[] value = result.getValue(family, column);
            return new String(value);
        }
    }
}
