// 내 번호 미리 고정
const myNumbers = [1, 2, 3, 4, 5, 6];

// 중복 없이 랜덤 번호 뽑는 함수
function getRandomNumbers(count, max) {
  const nums = [];
  while (nums.length < count) {
    const n = Math.floor(Math.random() * max) + 1;
    if (!nums.includes(n)) {
      nums.push(n);
    }
  }
  return nums;
}

// 번호 HTML로 보여주기
function showNumbers(containerId, numbers, highlightMatch = []) {
  const container = document.getElementById(containerId);
  numbers.forEach(num => {
    const span = document.createElement('span');
    span.className = 'number-box';
    if (highlightMatch.includes(num)) span.classList.add('highlight');
    span.textContent = num;
    container.appendChild(span);
  });
}

// 로또 번호 생성
const lottoNumbers = getRandomNumbers(6, 45);
const bonusNumber = getRandomNumbers(1, 45).find(n => !lottoNumbers.includes(n));

// 몇 개 맞았는지 확인
let matchCount = myNumbers.filter(n => lottoNumbers.includes(n)).length;
let isBonusMatched = myNumbers.includes(bonusNumber);

// 등수 판정
let resultText = "";
switch (matchCount) {
  case 6: resultText = "🎉 1등!"; break;
  case 5: resultText = isBonusMatched ? "🎊 2등 (보너스 일치!)" : "🥳 3등"; break;
  case 4: resultText = "😎 4등"; break;
  case 3: resultText = "🙂 5등"; break;
  default: resultText = "😭 꽝입니다... 다음 기회에!";
}

// 출력
showNumbers("myNumbers", myNumbers);
showNumbers("lottoNumbers", lottoNumbers, myNumbers); // 내 번호와 겹치는 부분 하이라이트
showNumbers("bonusNumber", [bonusNumber], myNumbers.includes(bonusNumber) ? [bonusNumber] : []);
document.getElementById("result").textContent = `맞은 개수: ${matchCount}개 → ${resultText}`;
