package com.leyou.item.web;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/5/21 14:52
 */
@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specService;

    /**
     * 根据分类id 查询规格组信息
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid")Long cid){
        return ResponseEntity.ok(specService.queryGroupByCid(cid));
    }

    /**
     * 根据组id查询规格参数
     * @param gid
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParamByGid(@RequestParam("gid")Long gid){

        return ResponseEntity.ok(specService.queryParamByGid(gid));
    }

    /**
     * 新增规格组
     * @param specGroup
     * @return
     */
    @PostMapping("group")
    public ResponseEntity<Void> addGroupParam(@RequestBody SpecGroup specGroup){
        this.specService.insertGroups(specGroup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 修改规格组
     * @param specGroup
     * @return
     */
    @PutMapping("group")
    public ResponseEntity<Void> updateGroups(@RequestBody SpecGroup specGroup){
        this.specService.updateGroups(specGroup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 删除规格组
     * @param id
     * @return
     */
    @DeleteMapping("group/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("id")Long id){
        this.specService.deleteGroups(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
