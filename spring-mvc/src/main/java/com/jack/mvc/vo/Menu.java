package com.jack.mvc.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 后台管理的菜单.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年5月29日
 */
@Getter
@Setter
public class Menu {

    private String name; // 菜单名称
    private String url; // 菜单 URL

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
