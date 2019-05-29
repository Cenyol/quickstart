package com.cenyol.demo.rc;

/**
 * @author Chenhanqun mail: chenhanqun1@corp.netease.com
 * @date 2019-05-28 20:01
 */
public enum ExtTypeEnum {
    User,
    Dept,
    AO,
    TMO,
    Other;

    String string() {
        return this.name();
    }
}
