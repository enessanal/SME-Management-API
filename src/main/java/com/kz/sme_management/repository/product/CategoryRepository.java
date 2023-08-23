package com.kz.sme_management.repository.product;

import com.kz.sme_management.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String>
{

}
