package com.pg.generate.controller;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Database;
import com.pg.generate.handler.BusinessStatus;
import com.pg.generate.handler.PageInfo;
import com.pg.generate.handler.Result;
import com.pg.generate.handler.ResultPage;
import com.pg.generate.service.DatabaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "活动模块")
@RequestMapping("/api/database")
@RestController
public class DatabaseController {

    private static Logger log = LoggerFactory.getLogger(DatabaseController.class);

    @Resource
    private DatabaseService databaseService;

    @ApiOperation("分页查询")
    @PostMapping(value = "/queryPage")
    public ResultPage<Database> queryPage(@RequestBody Database database) {
        log.info("活动模块-分页查询，参数database={}", database);
        Page<Database> page = databaseService.queryPage(database);
        PageInfo<Database> pageInfo = new PageInfo<Database>(page);
        return new ResultPage<Database>(BusinessStatus.SUCCESS_GET, pageInfo);
    }

    @ApiOperation("查询全部")
    @GetMapping(value = "/queryAll")
    public Result<List<Database>> queryAll() {
        log.info("活动模块-查询全部，参数database={}");
        List<Database> list = databaseService.queryAll();
        return new Result<List<Database>>(BusinessStatus.SUCCESS_GET, list);
    }

    @ApiOperation("查询单条记录")
    @GetMapping(value = "/queryOne")
    public Result<Database> queryOne(@RequestParam String tableId) {
        log.info("活动模块-查询单条记录，参数tableId={}", tableId);
        Database one = databaseService.queryOne(tableId);
        return new Result<Database>(BusinessStatus.SUCCESS_GET, one);
    }

    @ApiOperation("新增")
    @PostMapping(value = "/save")
    public Result<Database> insert(@RequestBody Database database) {
        log.info("活动模块-新增，参数database={}", database);
        databaseService.insert(database);
        return new Result<Database>(BusinessStatus.SUCCESS_ADD);
    }

    @ApiOperation("修改")
    @PutMapping(value = "/update")
    public Result<Database> update(@RequestBody Database database) {
        log.info("活动模块-修改，参数database={}", database);
        databaseService.update(database);
        return new Result<Database>(BusinessStatus.SUCCESS_UPDATE);
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/delete")
    public Result<Database> delete(@RequestParam String tableId) {
        log.info("活动模块-删除，参数tableId={}", tableId);
        databaseService.delete(tableId);
        return new Result<Database>(BusinessStatus.SUCCESS_DELETE);
    }

}
