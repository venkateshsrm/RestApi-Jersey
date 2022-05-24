package org.studyeasy.showroom.services;

import java.util.List;

import org.studyeasy.showroom.hibernate.DAO.ProductDAO;
import org.studyeasy.showroom.hibernate.entities.ProudctEntity;

public class ProductService {

	ProductDAO dao = new ProductDAO();
	
	

	public List<ProudctEntity> getProductsByBrands(int brandId) {
		List<ProudctEntity> productlist = dao.getProductsByBrand(brandId);
		return productlist;
	}



	

}
