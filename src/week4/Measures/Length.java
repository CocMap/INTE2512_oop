package week4.Measures;

public class Length {
        public int m = 0;
        public int cm = 0;
        public int mm = 0;

        public Length(int m, int cm, int mm){
            this.m = m;
            this.cm = cm;
            this.mm = mm;
        }

        public Length add(Length ob1, Length ob2) {
            return new Length(ob1.m + ob2.m, ob1.cm + ob2.cm, ob1.mm + ob2.mm);
        }

        public Length subtract(Length ob1, Length ob2) {
            return new Length(ob1.m - ob2.m, ob1.cm - ob2.cm, ob1.mm - ob2.mm);
        }

        public Length mul(Length ob, int n){
            return new Length(ob.m*n, ob.cm*n, ob.mm*n);
        }



}
