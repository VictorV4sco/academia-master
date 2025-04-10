package com.academiamaster.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academiamaster.dto.PaymentDTO;
import com.academiamaster.entities.Payments;
import com.academiamaster.repositories.PaymentsRepository;
import com.academiamaster.services.exceptions.DatabaseException;
import com.academiamaster.services.exceptions.ResourceNotFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentsRepository repository;
	
	@Transactional(readOnly = true)
	public List<PaymentDTO> findByMonthAndYear(Integer month, Integer year) {
		List<Payments> p = repository.findByMonthAndYear(month, year);
		return p.stream().map(pa -> new PaymentDTO(pa.getId(), pa.getPayerName(), pa.getType(), pa.getValue(), pa.getPaymentMoment())).collect(Collectors.toList());	
	}
	
	@Transactional(readOnly = true)
	public List<PaymentDTO> findByDate(Integer month, Integer year, Integer day) {
		List<Payments> p = repository.findByDay(month, year, day);
		if(p.size() == 0) {
			throw new ResourceNotFoundException("No payments on this day");
		}
		return p.stream().map(pa -> new PaymentDTO(pa.getId(), pa.getPayerName(), pa.getType(), pa.getValue(), pa.getPaymentMoment())).collect(Collectors.toList());	
	}
	
	@Transactional(readOnly = true)
	public Page<PaymentDTO> findPaymentsPagedByYear(Integer year, Pageable pageable) {
		Page<Payments> p = repository.findByYear(year, pageable);
		return p.map(pa -> new PaymentDTO(pa.getId(), pa.getPayerName(), pa.getType(), pa.getValue(), pa.getPaymentMoment()));
	}
	
	@Transactional
	public PaymentDTO insert(PaymentDTO dto) {
		Payments payment = new Payments();
		payment.setPayerName(dto.payerName());
		payment.setType(dto.type());
		payment.setValue(dto.value());
		payment.setPaymentMoment(dto.paymentMoment());
		
		Payments savedPayment = repository.save(payment);
		
		return new PaymentDTO(savedPayment.getId(), savedPayment.getPayerName(), savedPayment.getType(), savedPayment.getValue(), savedPayment.getPaymentMoment());
	}
	
	@Transactional
	public PaymentDTO update(Long id, PaymentDTO dto) {
		Payments payment = repository.getReferenceById(id);
		payment.setPayerName(dto.payerName());
		payment.setType(dto.type());
		payment.setValue(dto.value());
		payment.setPaymentMoment(dto.paymentMoment());
		Payments savedPayment = repository.save(payment);
		return new PaymentDTO(savedPayment.getId(), savedPayment.getPayerName(), savedPayment.getType(), savedPayment.getValue(), savedPayment.getPaymentMoment());

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
    		throw new ResourceNotFoundException("Recurso não encontrado");
    	}
    	try {
            repository.deleteById(id);    		
    	}
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
	}
}
