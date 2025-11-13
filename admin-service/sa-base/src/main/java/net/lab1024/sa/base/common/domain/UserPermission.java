package net.lab1024.sa.base.common.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * sa-token 所需的权限信息
 *
 */

@Data
public class UserPermission implements Serializable {

    /**
     * 权限列表
     */
    private List<String> permissionList;

    /**
     * 角色列表
     */
    private List<String> roleList;


}
