function Monster(name,hp,attack){ 
    /* 속성, 프로퍼티 */
    this.name = name;  // 이름
    this.currentHp = hp;    // 현재체력
    this.maxHp = hp;    // 최대체력
    this.attack = attack; // 공격력
    /* 멤버함수, 멤버메소드 */
    this.info = function(){
        dw("["+this.name+"("+this.currentHp + "/" + this.maxHp+")]");
    }
}