package vn.vku.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.vku.entity.Bill;

import java.time.LocalDate;
import java.util.List;

public interface BillService {

    Page<Bill> getAllBillSort(Pageable pageable);

    Page<Bill> getAllBill(Pageable pageable);

    Bill findById(int id);

    void deleteBill(int id);

    Bill saveBill(Bill bill);

    List<Bill> findByIdCustomer(String id);

    Page<Bill> getSearchItem(String itemSearch, Pageable pageable);

    List<Bill> getListOrder(LocalDate startDate, LocalDate endDate);
}
