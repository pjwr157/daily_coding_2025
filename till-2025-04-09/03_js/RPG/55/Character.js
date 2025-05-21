function Character(){
	this.name;	// 이름
	this.hp;	// 체력. 생명력
	this.max_hp;	// 체력. 생명력
	this.attack;	// 공격력

	this.exp = 0;	// 경험치
	this.next_exp = 100;	// 필요 경험치

	this.info = function(){
		document.write("["+this.name+"(💖"+this.hp+ " / "+this.max_hp+")]"+"(exp: "+this.exp+"/"+this.next_exp+")");
	}
}