package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dd_menu")
public class Ddmenu implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    private String url;
    @Column(name = "parent_id")
    private Integer parentId;
    @Transient
    private String text;
    private List<Ddmenu> list;

}
