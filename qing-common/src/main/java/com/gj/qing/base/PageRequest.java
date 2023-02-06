package com.gj.qing.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Gaojie
 * @Date: 2022/12/15
 * @Desc:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {


    /**
     * 页码，默认是1
     */
    private Integer pageNo = 1;

    /**
     * 页数大小，默认是10
     */
    private Integer pageSize = 10;
}
