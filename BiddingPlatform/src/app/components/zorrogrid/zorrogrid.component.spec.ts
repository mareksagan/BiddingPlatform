import { fakeAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { ZorrogridComponent } from './zorrogrid.component';

describe('ZorrogridComponent', () => {
  let component: ZorrogridComponent;
  let fixture: ComponentFixture<ZorrogridComponent>;

  beforeEach(fakeAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ZorrogridComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZorrogridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should compile', () => {
    expect(component).toBeTruthy();
  });
});
