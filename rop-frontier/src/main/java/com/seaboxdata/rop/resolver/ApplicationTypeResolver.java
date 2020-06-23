package com.seaboxdata.rop.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.vo.ApplicationTypeVo;
import com.seaboxdata.rop.input.ApplicationTypePageInput;
import com.seaboxdata.rop.service.NrdApplicationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用分类 -- resolver
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 14:31:50
 */
@Service
public class ApplicationTypeResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private NrdApplicationTypeService nrdApplicationTypeService;

    /**
     * 分页
     */
    public PaginationResult<ApplicationTypeVo> applicationTypeList(ApplicationTypePageInput applicationTypePageInput){
        return nrdApplicationTypeService.applicationTypeList(applicationTypePageInput);
    }

    /**
     * 全部
     */
    public List<ApplicationTypeVo> applicationTypeAll(ApplicationTypeVo applicationTypeVo){
        return nrdApplicationTypeService.applicationTypeAll(applicationTypeVo);
    }

    /**
     * 信息
     */
    public ApplicationTypeVo applicationTypeDetail(Integer appTypeId){
        return nrdApplicationTypeService.applicationTypeDetail(appTypeId);

    }

    /**
     * 保存
     */
    public Boolean applicationTypeSave(ApplicationTypeVo applicationTypeVo){
        return nrdApplicationTypeService.applicationTypeSave(applicationTypeVo);
    }

    /**
     * 修改
     */
    public Boolean applicationTypeUpdate(ApplicationTypeVo applicationTypeVo){
        return nrdApplicationTypeService.applicationTypeUpdate(applicationTypeVo);
    }

    /**
     * 删除
     */
    public Boolean applicationTypeDelete(Integer[] appTypeIds){
        return nrdApplicationTypeService.applicationTypeDelete(appTypeIds);
    }

}
