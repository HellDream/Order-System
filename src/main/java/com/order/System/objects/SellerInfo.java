package com.order.System.objects;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class SellerInfo {
    @Id
    private String id;
    private String username;
    private String password;
    private String openId;
    private Date createTime;
    private Date updateTime;

}
