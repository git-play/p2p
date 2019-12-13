package com.zking.p2p.mapper;

import com.zking.p2p.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeNodeMapper {

    /**
     * @return
     * 查询父节点
     */
    List<TreeNode> getList();

    List<TreeNode> getParentNodeId(Integer parentNodeId);

}