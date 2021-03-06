CREATE TABLE `attendance` (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `del_flag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `duration` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enter_image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enter_recording` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `entry_time` datetime DEFAULT NULL,
  `inspection_time` datetime DEFAULT NULL,
  `out_image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `out_recording` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `process` bigint(20) DEFAULT NULL,
  `realname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `work_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `inspection_record` (
  `id` bigint(20) NOT NULL,
  `check_person` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `conclusion` int(11) NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `duty` int(11) NOT NULL,
  `problem1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `problem2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `problem3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `problem4` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `problem5` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `problem6` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `serial` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `staff1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `staff2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `template_id` bigint(20) DEFAULT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `running_log` (
  `id` bigint(20) NOT NULL,
  `create_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hour` bigint(20) DEFAULT NULL,
  `operator_duty` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tag1` int(11) NOT NULL,
  `tag10` int(11) NOT NULL,
  `tag11` int(11) NOT NULL,
  `tag12` int(11) NOT NULL,
  `tag13` int(11) NOT NULL,
  `tag14` int(11) NOT NULL,
  `tag15` int(11) NOT NULL,
  `tag2` int(11) NOT NULL,
  `tag3` int(11) NOT NULL,
  `tag4` int(11) NOT NULL,
  `tag5` int(11) NOT NULL,
  `tag6` int(11) NOT NULL,
  `tag7` int(11) NOT NULL,
  `tag8` int(11) NOT NULL,
  `tag9` int(11) NOT NULL,
  `update_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `value1` decimal(19,2) DEFAULT NULL,
  `value10` decimal(19,2) DEFAULT NULL,
  `value11` decimal(19,2) DEFAULT NULL,
  `value12` decimal(19,2) DEFAULT NULL,
  `value13` decimal(19,2) DEFAULT NULL,
  `value14` decimal(19,2) DEFAULT NULL,
  `value15` decimal(19,2) DEFAULT NULL,
  `value2` decimal(19,2) DEFAULT NULL,
  `value3` decimal(19,2) DEFAULT NULL,
  `value4` decimal(19,2) DEFAULT NULL,
  `value5` decimal(19,2) DEFAULT NULL,
  `value6` decimal(19,2) DEFAULT NULL,
  `value7` decimal(19,2) DEFAULT NULL,
  `value8` decimal(19,2) DEFAULT NULL,
  `value9` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;