package org.studyeasy.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.showroom.hibernate.entities.BrandEntity;
import org.studyeasy.showroom.hibernate.entities.ProudctEntity;


public class ProductDAO {
	
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(ProudctEntity.class)
							.addAnnotatedClass(BrandEntity.class)
							.buildSessionFactory();

	

	public List<ProudctEntity> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<ProudctEntity> productlist;
		String sql = "from products where brandId='"+brandId+"'";
		productlist = session.createQuery(sql).getResultList();
		return productlist;
		
		
	}

}
