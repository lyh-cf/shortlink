package com.lyh.shortlink.project.test;

/*
 *@title LinkTableShardingTest
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/2/3 17:26
 */
public class LinkGoToTableShardingTest {
    public static final String SQL="CREATE TABLE `t_link_goto_%d`  (\n" +
            "  `id` bigint NOT NULL COMMENT 'ID',\n" +
            "  `full_short_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '完整短链接',\n" +
            "  `gid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分组标识',\n" +
            "  PRIMARY KEY (`id`) USING BTREE,\n" +
            "  UNIQUE INDEX `idx_unique_full_short_url`(`full_short_url` ASC) USING BTREE\n" +
            ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;";
    public static void main(String[] args) {
        for (int i=0;i<16;i++){
            System.out.printf((SQL)+"%n",i);
        }
    }
}
