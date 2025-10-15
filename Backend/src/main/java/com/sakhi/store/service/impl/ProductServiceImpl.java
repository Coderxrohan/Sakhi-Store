@Override
public Page<ProductDto> listProducts(Long categoryId, Long collectionId, Pageable pageable) {
    Page<Product> page;
    if (collectionId != null) {
        page = productRepo.findByCollectionId(collectionId, pageable);
    } else if (categoryId != null) {
        page = productRepo.findByCategoryId(categoryId, pageable);
    } else {
        page = productRepo.findAll(pageable);
    }
    return page.map(CatalogMapper::toDto);
}
