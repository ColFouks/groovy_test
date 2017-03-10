class Romans {
    def out_num = "", num
    def numbers = [1:'I',4:'IV',5:'V',9:'IX',10:'X',40:'XL',50:'L',90:'XC',100:'C',400:'CD',500:'D',900:'CM',1000:'M']
    def numbers_tr = ['I':1,'IV':4,'V':5,'IX':9,'X':10,'XL':40,'L':50,'XC':90,'C':100,'CD':400,'D':500,'CM':900,'M':1000]
    public Romans(num){
            this.num = num
     }
     public String toString(){
       if (this.num.toString().isInteger()){
            while (this.num){
                for (n in this.numbers.iterator().reverse()){
                    if (this.num - n.key >= 0){
                        this.out_num+=n.value
                        this.num-=n.key
                        break
                    }
                }
            }
        }
        else if(this.num instanceof String){
            this.out_num=0
            def str_num = []
            this.num.each{str_num.add(it)}
            def i
            for (i = 0; i<str_num.size();){
                if (numbers_tr[str_num[i]] < numbers_tr[str_num[i+1]]){
                    this.out_num+=numbers_tr[str_num[i]+str_num[i+1]]
                    i+=2
                }
                else{
                    this.out_num+=numbers_tr[str_num[i]]
                    i+=1
                }
            }
        }
        return this.out_num
    }
}
def n = Romans.newInstance("XL")