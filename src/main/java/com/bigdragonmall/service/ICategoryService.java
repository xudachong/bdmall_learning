package com.bigdragonmall.service;

import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.pojo.Category;

import java.util.List;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 21:00 2017/12/29
 * @
 */
public interface ICategoryService {

	ServerResponse addCategory(String categoryName, Integer parentId);
	ServerResponse updateCategoryName(Integer categoryId, String categoryName);
	ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
	ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
