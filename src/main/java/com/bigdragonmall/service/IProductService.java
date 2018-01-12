package com.bigdragonmall.service;

import com.bigdragonmall.common.ServerResponse;
import com.bigdragonmall.pojo.Product;
import com.bigdragonmall.vo.ProductDetailVo;
import com.github.pagehelper.PageInfo;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 13:11 2018/1/9
 * @
 */
public interface IProductService {

	ServerResponse saveOrUpdateProduct(Product product);

	ServerResponse<String> setSaleStatus(Integer productId, Integer status);

	ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

	ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

	ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

	ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

	ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);

}
