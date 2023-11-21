package com.QRCodeAPI.Repository;

import com.QRCodeAPI.Entity.QRCodeEntity;

//import jakarta.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

@Repository
public interface QRCodeRepository extends JpaRepository<QRCodeEntity, Long> {
    // You can define custom query methods here if needed
//	@Service
//	public class QRCodeService {
//
//	    @Autowired
//	    private QRCodeRepository qrCodeRepository;
//
//	    @Transactional
//	    public void saveQRCodeEntity(QRCodeEntity entity) {
//	        try {
//	            qrCodeRepository.save(entity);
//	            // Additional processing or business logic if needed
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            throw new RuntimeException("Error while saving QRCodeEntity");
//	        }
//	    }
//	}

}
