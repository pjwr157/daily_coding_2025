var orc = new Monster("오크전사",100,10);
var elf = new Character("엠피스",200,30);

displayCharactersInfo();

//전투 처리 ( 한 턴 <한차례의 서로간의 공격> )
//전투 시작 메세지
hr();
dw("전투 시작")
hr();

// 공격 메세지 출력 추가( ex. 오크전사가 엠피스에게 데미지를 10 입혔습니다. )
var monsterDamage = getRandomAttackValue(orc.attack);
var playerDamage = getRandomAttackValue(elf.attack);

orc.currentHp = orc.currentHp - playerDamage;
dw(elf.name + "가 " + orc.name + "에게 데미지를 "+playerDamage +" 입혔습니다.<br>");
elf.currentHp = elf.currentHp - monsterDamage;
dw(orc.name + "가 " + elf.name + "에게 데미지를 "+monsterDamage +" 입혔습니다.<br>");


displayCharactersInfo();

function getRandomAttackValue(attack){
    attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
    var random = Math.floor(Math.random()*attack);  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
    return random;
}

function displayCharactersInfo(){
    hr();
    elf.info();
    orc.info();
    hr();
}