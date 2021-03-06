package com.zetool.beancopy.field;


import java.util.*;

import com.google.gson.Gson;
import com.zetool.beancopy.annotation.CopyFrom;
import com.zetool.beancopy.util.CollectionUtils;

/**
 * 封装Field的FieldContext类
 * @author loki02
 * @date 2020年11月30日
 */
public abstract class FieldHelper {
	
	/**
	 * 将一个对象转换为字符串
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if(obj != null) {
			return new Gson().toJson(obj);
		}
		return "null";
	}

	/**
	 * 
	 * @return 返回字段名
	 */
	public abstract String getName();
	/**
	 * 
	 * @return 返回字段类型
	 */
	public abstract Class<?> getType();
	
	/**
	 * 是否是final变量
	 * @return
	 */
	public abstract boolean isFinal();
	
	/**
	 * 是否是静态变量
	 * @return
	 */
	public abstract boolean isStatic();
	
	/**
	 * 设置这个是哪个对象的字段，与对象绑定
	 * @return
	 */
	public abstract FieldHelper setObject(Object obj);
	
	/**
	 * 
	 * @return 返回字段值
	 */
	public abstract Object getValue();
	
	/**
	 * 设置当前类的字段值
	 * @return 当前类
	 */
	public abstract FieldHelper setValue(Object value);
	
	/**
	 * 拷贝当前字段的值并返回
	 * @return 拷贝的字段值
	 */
	public abstract Object cloneValue();
	
	private static interface FieldContextFilter {
		/**
		 * 过滤出一部分合法的fieldcontext
		 * @param fieldContexts
		 * @return
		 */
		public Collection<FieldHelper> filter(Collection<FieldHelper> fieldContexts);
	}

	
	protected static class CopyFromFieldContextFilter implements FieldContextFilter {
		private CopyFrom copyFrom;
		
		public CopyFromFieldContextFilter(CopyFrom copyFrom) {
			this.copyFrom = copyFrom;
			if(copyFrom == null) throw new IllegalArgumentException();
		}
		
		/**
		 * 过滤出集合中的字段，这个字段包含在copyFrom注解的fields中
		 * @param fieldContexts
		 * @return
		 */
		@Override
		public Collection<FieldHelper> filter(Collection<FieldHelper> fieldContexts) {
			Set<String> fieldNameSet = CollectionUtils.toSet(copyFrom.thisFields());
			List<FieldHelper> result = new ArrayList<FieldHelper>();
			for (FieldHelper fieldContext : fieldContexts)
				if(fieldNameSet.contains(fieldContext.getName())) result.add(fieldContext);
			return result;
		}
		/**
		 * 过滤出集合中的字段，这个字段包含在copyFrom注解的fields中
		 * @param fieldContexts
		 * @return
		 */
		public Map<String, FieldHelper> filter(Map<String, FieldHelper> fieldContexts) {
			Set<String> fieldNameSet = CollectionUtils.toSet(copyFrom.thisFields());
			Map<String, FieldHelper> result = new HashMap<String, FieldHelper>();
			for (String name : fieldContexts.keySet()) 
				if(fieldNameSet.contains(name)) result.put(name, fieldContexts.get(name));
			return result;
		}
	}
}
