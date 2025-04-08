
// - 케릭터 정보 표시에서 공격력 수치를 제거하였습니다.



function Monster(name,hp,attack){
	this.name = name;	// 이름
	this.hp = hp;	// 현재 체력. 생명력
	this.max_hp = hp;	// 최대 체력. 생명력
	this.attack = attack;	// 공격력

	this.info = function(){
		document.write("["+this.name+"("+this.hp+ " / "+this.max_hp+")]");
	}
}

function Character(){
	this.name;	// 이름
	this.hp;	// 체력. 생명력
	this.max_hp;	// 체력. 생명력
	this.attack;	// 공격력

	this.info = function(){
		document.write("["+this.name+"("+this.hp+ " / "+this.max_hp+")]");
	}
}

var dragon = new Monster("드래곤",100,10);

var elf = new Character();
elf.name = "성모";
elf.hp = 200;
elf.max_hp = 200;
elf.attack = 20;

dragon.info();
br();br();
elf.info();

hr();
dw("전투시작");
hr();

//todo
// elf.hp = elf.hp - dragon.attack;		// 10 고정 뎀



var elf_attack = r(elf.attack);
var dragon_attack = r(dragon.attack);

hr();
//todo 플레이어 데미지 표시
dw("플레이어 데미지:"+elf_attack);
hr();
//todo 몬스터 데미지 표시
dw("몬스터 데미지:"+dragon_attack);
hr();


elf.hp = elf.hp - dragon_attack;		// 1~10 랜덤 뎀

dragon.hp = dragon.hp - elf_attack;	


dragon.info();
br();br();
elf.info();

