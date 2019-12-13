package com.zking.p2p.service;

import com.zking.p2p.model.TreeNode;

import java.util.List;

public interface ITreeNodeService {

    /**
     * @return
     * 查询父节点
     */
    List<TreeNode> getList();

    /**
     * 查询子节点
     * @param parentNodeId
     * @return
     */
    List<TreeNode> getParentNodeId(Integer parentNodeId);

}