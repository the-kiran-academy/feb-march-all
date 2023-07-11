package com.jbk.serviceIMPL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
import com.jbk.model.Category;
import com.jbk.model.Charges;
import com.jbk.model.FinalProduct;
import com.jbk.model.Product_Supplier_Category;
import com.jbk.model.Supplier;
import com.jbk.model.ToDo;
import com.jbk.service.ProductService;
import com.jbk.validation.ValidateProdut;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ValidateProdut validateProdut;

	Map<String, String> errorMap;
	Map<Integer, Map<String, String>> validatMap = new HashMap<Integer, Map<String, String>>();
	int alreadyExistsCounter = 0;
	List<Integer> alreadyExistsRows = new ArrayList<Integer>();

	Map<String, Object> map = new LinkedHashMap<String, Object>();

	int lastRowNum = 0;

	@Override
	public Boolean addProduct(Product product) {

		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		product.setProductId(Long.parseLong(id));
		return dao.addProduct(product);
	}

	@Override
	public Product getProductById(Long id) {
		return dao.getProductById(id);
	}

	@Override
	public Product getProductByName(String getProductByName) {
		return dao.getProductByName(getProductByName);
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public Boolean deleteProduct(Long id) {
		return dao.deleteProduct(id);
	}

	@Override
	public Boolean updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> sortProducts(String sortBy, String fieldName) {
		return dao.sortProducts(sortBy, fieldName);
	}

	@Override
	public List<Product> getMaxPriceProducts() {
		return dao.getMaxPriceProducts();
	}

	@Override
	public Double countSumOfProductPrice() {

		double sumOfProductPrice = dao.countSumOfProductPrice();

		String formattedNumber = String.format("%.3f", sumOfProductPrice);
		System.out.println(formattedNumber);

		return Double.parseDouble(formattedNumber);

	}

	@Override
	public Long getTotalCountOfProducts() {

		return dao.getTotalCountOfProducts();
	}

	@Override
	public Product_Supplier_Category getProductWithCategorySupplier(Long productId) {
		
		Product_Supplier_Category psc=new Product_Supplier_Category();
		
		Product product = getProductById(productId);
		
		psc.setProduct(product);
		
		try {
			Category category = restTemplate.getForObject("http://CATEGORY-SERVICE/category/get-category-by-id/"+product.getCategoryId(), Category.class);
			psc.setCategory(category);
		} catch (ResourceAccessException e) {
			psc.setCategory(null);
		}
		
		
		try {
			Supplier supplier = restTemplate.getForObject("http://SUPPLIER-SERVICE/supplier/get-supplier-by-id/"+product.getSupplierId(), Supplier.class);
			psc.setSupplier(supplier);
		} catch (ResourceAccessException e) {
			psc.setSupplier(null);
		}
		
		//ToDo todo = restTemplate.getForObject("http://jsonplaceholder.typicode.com/todos/1", ToDo.class);
		
	//	System.out.println(todo);
		
		return psc;
	}

	

//	public List<Product> readExcel(String filePath) {
//		List<Product> list = new ArrayList<Product>();
//		try {
//
//			// FileInputStream fileInputStream=new FileInputStream(filePath);
//
//			// Workbook workbook=new XSSFWorkbook(fileInputStream);
//
//			Workbook workbook = new XSSFWorkbook(filePath);
//
//			Sheet sheet = workbook.getSheetAt(0);
//
//			// lastRowNum = sheet.getLastRowNum()-2;
//
//			Iterator<Row> rows = sheet.rowIterator();
//
//			while (rows.hasNext()) {
//				Row row = (Row) rows.next();
//				// exclude header row
//				int rowNum = row.getRowNum();
//				if (rowNum == 0) {
//					continue;
//				}
//
//				lastRowNum = row.getRowNum();
//				Product product = new Product();
//				String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
//
//				// String newId=id.concat(String.valueOf(rowNum));
//
//				Random random = new Random();
//				String numbers = "123456789";
//				char[] otp = new char[1];
//
//				for (int i = 0; i < 1; i++) {
//
//					otp[i] = numbers.charAt(random.nextInt(numbers.length()));
//				}
//
//				int number = Integer.parseInt(new String(otp));
//
//				product.setProductId(Long.parseLong(id.concat(String.valueOf(number))));
//
//				Iterator<Cell> cells = row.cellIterator();
//
//				while (cells.hasNext()) {
//					Cell cell = (Cell) cells.next();
//
//					int columnIndex = cell.getColumnIndex();
//
//					switch (columnIndex) {
//					case 0: {
//						product.setProductName(cell.getStringCellValue());
//						break;
//					}
//
//					case 1: {
//						Supplier supplier = new Supplier();
//						supplier.setSupplierId((long) cell.getNumericCellValue());
//						product.setSupplierId(supplier);
//						break;
//					}
//
//					case 2: {
//						Category category = new Category();
//						category.setCategoryId((long) cell.getNumericCellValue());
//						product.setCategoryId(category);
//						break;
//					}
//
//					case 3: {
//						product.setProductQTY((int) cell.getNumericCellValue());
//
//						break;
//					}
//					case 4: {
//						product.setProductPrice(cell.getNumericCellValue());
//
//						break;
//					}
//
//					}
//
//				}
//
//				errorMap = validateProdut.validateProduct(product);
//				if (errorMap.isEmpty()) {
//
//					Product dbProduct = dao.getProductByName(product.getProductName());
//					if (dbProduct == null) {
//						list.add(product);
//					} else {
//						alreadyExistsCounter = alreadyExistsCounter + 1;
//						alreadyExistsRows.add(row.getRowNum());
//					}
//
//				} else {
//					validatMap.put(Integer.valueOf(row.getRowNum() + 1), errorMap);
//				}
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
//
//	}
//
//	@Override
//	public Map<String, Object> uploadSheet(MultipartFile file) {
//		String path = "src/main/resources/";
//		String name = file.getOriginalFilename();
//		int addedCount = 0;
//		try (FileOutputStream fos = new FileOutputStream(path + File.separator + name)) {
//			byte[] data = file.getBytes();
//			fos.write(data);
//
//			List<Product> list = readExcel(path + File.separator + name);
//
//			addedCount = dao.uploadProdcuts(list);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		map.put("Total Record In Sheet", lastRowNum);
//		map.put("Uploaded Record In Db", addedCount);
//		map.put("Total Exists Records In DB", alreadyExistsCounter);
//		map.put("Row Num, Exists Record In DB", alreadyExistsRows);
//		map.put("Excluded Record Count", validatMap.size());
//		map.put("Bad Records Row Num", validatMap);
//
//		return map;
//	}
//
	@Override
	public FinalProduct finalProduct(Long productId) {

		Product product = dao.getProductById(productId);
		FinalProduct finalProduct = null;
		Category category=null;
		Supplier supplier=null;
		try {
			 category= restTemplate.getForObject("http://CATEGORY-SERVICE/category/get-category-by-id/"+product.getCategoryId(), Category.class);
			
		} catch (ResourceAccessException e) {
			return finalProduct;
		}
		
		try {
			 supplier = restTemplate.getForObject("http://SUPPLIER-SERVICE/supplier/get-supplier-by-id/"+product.getSupplierId(), Supplier.class);
			
		} catch (ResourceAccessException e) {
			
		}
		
		
		if (product != null) {
			finalProduct = new FinalProduct();
			// calculation gst productPrice*gst/100
			double gstAmount = product.getProductPrice() * category.getGst() / 100;

			// calculate discount productPrice*discount/100
			double discountAmount = product.getProductPrice() * category.getDiscount() / 100;

			// calculate finalProductPrice

			double finalProductPrice = product.getProductPrice() + gstAmount
					+ category.getDeliveryCharge() - discountAmount;

			Charges charges = new Charges();
			charges.setDeliveryCharge(category.getDeliveryCharge());
			charges.setGstAmount(gstAmount);

			finalProduct.setProductId(productId);
			finalProduct.setProductName(product.getProductName());
			finalProduct.setCategoryId(category);
			finalProduct.setSupplierId(supplier);
			finalProduct.setProductQTY(product.getProductQTY());
			finalProduct.setProductPrice(product.getProductPrice());
			finalProduct.setCharges(charges);
			finalProduct.setDiscountAmount(discountAmount);
			finalProduct.setFinalProductPrice(finalProductPrice);
		}

		return finalProduct;
	}

}
