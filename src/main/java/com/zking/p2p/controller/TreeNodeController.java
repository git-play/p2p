package com.zking.p2p.controller;


import com.zking.p2p.model.TreeNode;
import com.zking.p2p.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/TreeNodeController")
@Controller
public class TreeNodeController {

    @Autowired
    private ITreeNodeService treeNodeService;


    @RequestMapping(value = "/toTreeNode")
    @ResponseBody
    public  Map toTreeNode(HttpServletRequest request, HttpServletResponse response, @RequestParam Map map, Model model){
        List<TreeNode> ts = treeNodeService.getList();
        for (TreeNode treeNode : ts) {
            treeNode.setChildren(getChildren(treeNode.getTreeNodeId()));
        }
        map.put("result",ts);
        map.put("code",0);

        return map;//逻辑视图名
    }
    public  List<TreeNode> getChildren(Integer treeNodeId){
        List<TreeNode> ts =  treeNodeService.getParentNodeId(treeNodeId);
        for (TreeNode t : ts) {
            this.getChildren(t.getTreeNodeId());
        }
        return ts;
    }


}
