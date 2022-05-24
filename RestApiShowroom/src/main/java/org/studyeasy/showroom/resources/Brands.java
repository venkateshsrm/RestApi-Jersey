package org.studyeasy.showroom.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.studyeasy.showroom.hibernate.entities.BrandEntity;
import org.studyeasy.showroom.hibernate.entities.ProudctEntity;
import org.studyeasy.showroom.services.BrandsService;
import org.studyeasy.showroom.services.ProductService;

@Path("/showroom/brands")
public class Brands {
	BrandsService service = new BrandsService();
	
	ProductService productservice = new ProductService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list  = service.getBrands();
		return list;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postBrands(BrandEntity brand) {
	service.addBrand(brand);
	}
	
	
	@PUT
	@Path("/brands/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrands(@PathParam("brandId")  int brandId, BrandEntity updatedBrand) {
	updatedBrand.setBrandId(brandId);
	service.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/brands/{brandId}")
	public void deleteBrands(@PathParam("brandId") int brandId) {
	service.deleteBrand(brandId);
	}
	
	@GET
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProudctEntity> getProductsByBrand(@PathParam("brandId") int brandId) {
		List<ProudctEntity> productlist  = productservice.getProductsByBrands(brandId);
		return productlist;
	}

}
