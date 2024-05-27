package vn.vku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.vku.entity.Bill;
import vn.vku.repository.BillRepository;
import vn.vku.service.BillService;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;

    @Override
    public Page<Bill> getAllBillSort(Pageable pageable) {
        Sort sort = Sort.by("status").ascending(); // hoặc .descending()
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return billRepository.findAll(sortedPageable);
    }

    @Override
    public Page<Bill> getAllBill(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public Bill findById(int id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBill(int id) {
        billRepository.deleteById(id);
    }

    @Override
    public Bill saveBill(Bill bill) {
        return this.billRepository.save(bill);
    }

    @Override
    public List<Bill> findByIdCustomer(String id) {
        return this.billRepository.findByList(id);
    }

    @Override
    public Page<Bill> getSearchItem(String itemSearch, Pageable pageable) {
        return this.billRepository.findByName(itemSearch,pageable);
    }

    @Override
    public List<Bill> getListOrder(LocalDate startDate, LocalDate endDate) {
        return this.billRepository.getList(startDate,endDate);
    }
}
