import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckpostDetailsComponent } from './checkpost-details.component';

describe('CheckpostDetailsComponent', () => {
  let component: CheckpostDetailsComponent;
  let fixture: ComponentFixture<CheckpostDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckpostDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckpostDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
