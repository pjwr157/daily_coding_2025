function Monster(name,hp,attack){
	this.name = name;	// 이름
	this.hp = hp;	// 현재 체력. 생명력
	this.max_hp = hp;	// 최대 체력. 생명력
	this.attack = attack;	// 공격력

	this.info = function(){
		document.write("["+this.name+"("+this.hp+ " / "+this.max_hp+")]");
	}
}
