var dragon = new Monster("드래곤",100,20,100,1000);

var elf = new Character();
elf.name = "성모";
elf.hp = 200;
elf.max_hp = 200;
elf.attack = 20;
elf.exp = 0;
elf.next_exp = 300;
elf.gold = 0;

hr(); elf.info(); br();
dragon.info();

hr();
dw("전투시작");
hr();


function proc_battle(){
	var elf_attack = r(elf.attack);
	var dragon_attack = r(dragon.attack);
	
	hr();
	dw("🏹플레이어 데미지:"+elf_attack);
	hr();
	dw("🪓몬스터 데미지:"+dragon_attack);
	hr();
	
	elf.hp = elf.hp - dragon_attack;		// 1~10 랜덤 뎀
	dragon.hp = dragon.hp - elf_attack;	
	
	elf.info(); br();
	dragon.info();
}



while(true){
	proc_battle();

	if(elf.hp <= 0 || dragon.hp <= 0){
		break;
	}
}


br();dw("전투종료"); br();
dw("불쌍한 "+dragon.name+", "+elf.name+"에게 경험치 "+dragon.exp+" 을 주고 죽었습니다.");
elf.exp = elf.exp + dragon.exp;
br();
dw(dragon.gold+" 골드를 얻었습니다.");
elf.gold = elf.gold + dragon.gold;


hr();hr();

elf.info();

