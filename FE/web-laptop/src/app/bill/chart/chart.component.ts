import { Component, OnInit ,ViewChild} from '@angular/core';
import { Chart } from 'chart.js';
import {Title} from "@angular/platform-browser";
import {BillService} from "../../services/bill.service";
import {IBill} from "../../interface/IBill";
@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {
  data = [6,3, 4, 3, 5,1];
  billList: IBill[ ]=[];
  constructor(private titleService: Title, private billService: BillService) { }

  ngOnInit(): void {
    this.titleService.setTitle("Thống Kê");
    this.billService.getAll().subscribe((data) =>{
      this.billList = data.content;
    });

  }
  canvas: any;
  ctx: any;
  @ViewChild('mychart') mychart:any;

  ngAfterViewInit() {
    this.canvas = this.mychart.nativeElement;
    this.ctx = this.canvas.getContext('2d');

    new Chart(this.ctx, {
      type: 'bar',
      data: {
        datasets: [{
          label: 'Số Lượng bán ra',
          data: this.data,
          backgroundColor: "rgb(115 185 243 / 65%)",
          borderColor: "#007ee7",
          fill: true,
        }],
        labels: ['Asus', 'Dell', 'Apple','Hp', 'Lenovo','MSI']
      },
    });
  }
}
