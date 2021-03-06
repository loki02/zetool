package com.zetool.beancopy.field.checkor;

import com.zetool.beancopy.field.FieldHelper;

import java.util.List;
import java.util.Map;

/**
 * 一个映射对
 * @author loki02
 * @date 2020年12月1日
 */
public interface CopyPair<S, T>{

	/**
	 * 拷贝S给T
	 * @return
	 */
	public T cloneSourceToTarget(S sourceObj);

	/**
	 * 获取源 可拷贝字段集合
	 * @return
	 */
	public Map<String, FieldHelper> getSourceFieldMap();

	/**
	 * 获取目标 需要拷贝的字段集合
	 * @return
	 */
	public Map<String, FieldHelper> getTargetFieldMap();

	/**
	 * 获取字段映射集合
	 * @return
	 */
	public List<FieldPair> getFieldContextPairList();
	
	/**
	 * 检查source 和 target 是否可以相互拷贝
	 * @return
	 */
	public default boolean check(){
		return true;
	}
}