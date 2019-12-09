package com.zking.p2p.util;//package com.zking.zwd.util;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Aspect  //启用aop功能
//public class PageAspect {
//
//    @Around(value = "execution(* *..*Service.*Page(..))")
//    public  Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        //1.获取目标方法的执行参数
//        Object[] args = proceedingJoinPoint.getArgs();
//
//        PageBean pageBean=null;
//        for (Object arg : args) {
//            if(arg instanceof  PageBean){
//                pageBean = (PageBean) arg;
//                break;
//            }
//        }
//
//        //2.判断是否分页，并设置分页参数到PageHelper
//        if(null !=pageBean && pageBean.isPagination()){
//            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
//        }
//
//        //3.执行目标方法
//        Object result = proceedingJoinPoint.proceed(args);
//
//        //4.设置分页参数
//        if(null !=pageBean && pageBean.isPagination()&& null !=result && result instanceof  List){
//            List list = (List) result;
//
//            PageInfo pageInfo = new PageInfo(list);
//            pageBean.setTotal(pageInfo.getTotal()+"");
//
//        }
//
//        return  result;
//    }
//
//}
