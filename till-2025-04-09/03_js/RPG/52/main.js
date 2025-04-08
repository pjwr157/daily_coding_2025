// - 공격력을 해당 공격력 수치와 0사이의 값이 랜덤으로 나오도록 수정하였습니다.					
// 	1.다음 함수를 추가	function getRandomAttackValue(attack){			
// 			attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로		
// 			var random = Math.floor(Math.random()*attack);  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴		
// 			return random;		
// 		}			

// 	2.공격력으로 상대 체력을 깍는 처리를 하던 부분을 위 함수를 거친 attack 값으로 처리				
// - 공격 메세지 출력 추가( ex. 오크전사가 엠피스에게 데미지를 10 입혔습니다. )					
// 	서로 데미지를 입힐 때 누가 누구에게 몇의 데미지를 입혔는지를 출력 처리				




function Monster(name, hp, attack) {
	this.name = name;	// 이름
	this.hp = hp;	// 체력. 생명력
	this.attack = attack;	// 공격력

	this.info = function () {
		document.write("이름" + this.name + " HP:" + this.hp + " 공격력:" + this.attack);
	}
}

function Character() {
	this.name;	// 이름
	this.hp;	// 체력. 생명력
	this.attack;	// 공격력

	this.info = function () {
		document.write("이름" + this.name + " HP:" + this.hp + " 공격력:" + this.attack);
	}
}

var dragon = new Monster("드래곤", 100, 10);

var elf = new Character();
elf.name = "성모";
elf.hp = 200;
elf.attack = 20;

dragon.info();
hr();
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
dw("플레이어 데미지:" + elf_attack);
hr();
//todo 몬스터 데미지 표시
dw("몬스터 데미지:" + dragon_attack);
hr();


elf.hp = elf.hp - dragon_attack;		// 1~10 랜덤 뎀

dragon.hp = dragon.hp - elf_attack;


dragon.info();
br(); br();
elf.info();

