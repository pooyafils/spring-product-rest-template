# Rest Template 
### Overview
The RestTemplate offers templates for common scenarios by HTTP method, in addition to the generalized exchange and execute methods that support of less frequent cases.
### Development note
rest template leave us with many option to ask data via http methods. we will check some of them here
1. getting object by id
```
    public Product getById(int id) {
        System.out.println(apihost + PRODUCT_PATH + id);
        return restTemplate.getForObject(apihost + PRODUCT_PATH + id, Product.class);
    }
```
2. getting list of objects 
```
    public ResponseEntity<Product[]> getAllProduts() {
        return restTemplate.getForEntity(apihost + PRODUCT_PATH, Product[].class);
    }
```
3. posting a object 
```
  public URI postProduct(Product product) {
        return restTemplate.postForLocation(apihost + PRODUCT_PATH, product);
    }
```
4. editing the object 
```
   public void editProduct(int id, Product product) {
        restTemplate.put(apihost + PRODUCT_PATH + id, product);
    }
```