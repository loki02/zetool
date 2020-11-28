package com.zetool.beancopy.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * 集合工具类
 * 封装集合常用操作
 * @author Rnti
 *
 */
public final class CollectionUtils {
	/**
	 * 将一个数组T[]转换成HashSet<R>. 
	 * 如果T[] == null 返回空集合
	 * @param <T, R>
	 * @param array
	 * @return
	 */
	public final static <T, R>Set<R> toSet(T array[], Function<T, R> call){
		if(array == null) return new HashSet<R>();
		Set<R> list = new HashSet<>(array.length);
		for(T t : array) list.add(call.apply(t));
		return list;
	}
	/**
	 * 将一个数组T[]转换成HashSet<T>. 如果T[] == null 返回空集合
	 * @param <T>
	 * @param array
	 * @return
	 */
	public final static <T>Set<T> toSet(T array[]){
		if(array == null) return new HashSet<T>();
		Set<T> list = new HashSet<>(array.length);
		for(T t : array) list.add(t);
		return list;
	}
	/**
	 * 将一个数组Iterable<T> items转换成HashSet<R>. 如果Iterable<T> == null 返回空集合
	 * @param <T, R>
	 * @param array
	 * @return
	 */
	public final static <T, R>Set<R> toSet(Iterable<T> items, Function<T, R> call){
		if(items == null) return new HashSet<R>();
		Set<R> list = new HashSet<>();
		for(T t : items) list.add(call.apply(t));
		return list;
	}
	/**
	 * 将一个数组Iterable<T> items转换成HashSet<T>. 如果Iterable<T> == null 返回空集合
	 * @param <T>
	 * @param array
	 * @return
	 */
	public final static <T>Set<T> toSet(Iterable<T> items){
		if(items == null) return new HashSet<T>();
		Set<T> list = new HashSet<>();
		for(T t : items) list.add(t);
		return list;
	}
	
	/**
	 * 将一个数组T[]转换成ArrayList<T>. 如果T[] == null 返回空集合
	 * @param <T>
	 * @param array
	 * @return
	 */
	public final static <T>List<T> toList(T array[]){
		if(array == null) return new ArrayList<>();
		List<T> list = new ArrayList<>(array.length);
		for(T t : array) 
			list.add(t);
		return list;
	}
	
	/**
	 * 将array[]添加到collection中
	 * @param <T>
	 * @param list
	 * @param array
	 */
	public static <T>void addAll(Collection<T> collection, T array[]){
		if(array == null) return;
		for(T t : array)
			collection.add(t);
	}
}