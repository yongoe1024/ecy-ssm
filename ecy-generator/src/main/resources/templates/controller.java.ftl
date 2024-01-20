package ${package.Controller};

import ${package.Service}.${table.serviceName};
import com.yongoe.ecy.config.aop.WebLog;
import com.yongoe.ecy.${packageName}.controller.vo.excel.${entity}Excel;
import com.yongoe.ecy.${packageName}.controller.vo.req.${entity}Req;
import com.yongoe.ecy.${packageName}.controller.vo.res.${entity}Res;
import com.yongoe.ecy.${packageName}.convert.${entity}Convert;
import com.yongoe.ecy.${packageName}.entity.${entity};
import com.yongoe.ecy.utils.ExcelUtils;
import com.yongoe.ecy.utils.PageUtils;
import com.yongoe.ecy.utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import java.util.List;

/**
 * ${moduleName}
 *
 * @author ${author}
 * @since ${createTime}
 */
@RestController
@RequestMapping("/${packageName}/${entity?lower_case}")
public class ${table.controllerName} {
    @Resource
    private ${table.serviceName} ${table.serviceName?uncap_first};
    @Resource
    private ${entity}Convert ${entity?uncap_first}Convert;

    //@WebLog(description = "${moduleName}-查询数据")
    @PostMapping("/page")
    public R page(@RequestBody ${entity}Req req) {
        ${entity} entity = ${entity?uncap_first}Convert.req2Entity(req);
        Page<${entity}> page = ${table.serviceName?uncap_first}.get${entity}ByPage(Page.of(req.getCurrent(), req.getSize()), entity);
        Page<${entity}Res> resPage = ${entity?uncap_first}Convert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @WebLog(description = "${moduleName}-添加数据")
    @PostMapping("/add")
    public R add(@RequestBody ${entity}Req req) {
        ${entity} ${entity?uncap_first} = ${entity?uncap_first}Convert.req2Entity(req);
        ${table.serviceName?uncap_first}.save(${entity?uncap_first});
        return R.success("添加成功");
    }

    @WebLog(description = "${moduleName}-修改数据")
    @PostMapping("/update")
    public R update(@RequestBody ${entity}Req req) {
        ${entity} ${entity?uncap_first} = ${entity?uncap_first}Convert.req2Entity(req);
        ${table.serviceName?uncap_first}.updateById(${entity?uncap_first});
        return R.success("修改成功");
    }

    @WebLog(description = "${moduleName}-删除数据")
    @PostMapping("/delete/{ids}")
    public R delete(@PathVariable List<Long> ids) {
        ${table.serviceName?uncap_first}.removeByIds(ids);
        return R.success("删除成功");
    }

    @WebLog(description = "${moduleName}-导入数据")
    @PostMapping("/upload")
    public R upload(MultipartFile file) {
        List<${entity}Excel> excelList = ExcelUtils.upload(file, ${entity}Excel.class);
        List<${entity}> list = ${entity?uncap_first}Convert.excel2EntityList(excelList);
        ${table.serviceName?uncap_first}.saveBatch(list);
        return R.success("导入成功");
    }

    @WebLog(description = "${moduleName}-导出数据")
    @GetMapping("/export")
    public void export(${entity}Req req, HttpServletResponse response) {
        ${entity} entity = ${entity?uncap_first}Convert.req2Entity(req);
        Page<${entity}> page = ${table.serviceName?uncap_first}.get${entity}ByPage(Page.of(-1, -1), entity);
        List<${entity}Excel> list = ${entity?uncap_first}Convert.entity2ExcelList(page.getRecords());
        ExcelUtils.export(response, list, ${entity}Excel.class);
    }
}