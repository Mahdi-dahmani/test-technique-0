import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  

  constructor(private testService:TestService){};
  
  ngOnInit(): void {
      
  }

  result!: number;

  

  onFileSelected(event: any): void {
    const file: File = event.target.files[0];
    if (file) {
      this.testService.uploadFile(file).subscribe(
        sum =>{ this.result = sum;

        },
        error => {console.error(error); }) 
      };
    }
  }
 


