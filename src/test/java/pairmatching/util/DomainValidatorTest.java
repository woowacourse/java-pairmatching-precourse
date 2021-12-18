package pairmatching.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DomainValidatorTest {

	@Test
	void 도메인_이름_검증() {
		DomainValidator.validateInputForm("프론트엔드, 레벨1, 자동차경주");
		DomainValidator.validateInputForm("프론트엔드, 레벨1, 로또");
		DomainValidator.validateInputForm("프론트엔드, 레벨1, 숫자야구게임");
		DomainValidator.validateInputForm("프론트엔드, 레벨2, 장바구니");
		DomainValidator.validateInputForm("프론트엔드, 레벨2, 결제");
		DomainValidator.validateInputForm("프론트엔드, 레벨2, 지하철노선도");
		DomainValidator.validateInputForm("프론트엔드, 레벨4, 성능개선");
		DomainValidator.validateInputForm("프론트엔드, 레벨4, 배포");
	}

	@Test
	void 코스_이름_예외() {
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm(", 레벨1, 자동차경주"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm(" , 레벨1, 자동차경주"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("1, 레벨1, 자동차경주"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론 엔드, 레벨1, 자동차경주"));
	}

	@Test
	void 레벨_이름_예외() {
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, , 자동차경주"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드,  , 자동차경주"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, 레벨0, 자동차경주"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, 레벨10, 자동차경주"));

	}

	@Test
	void 미션_이름_예외() {
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, 레벨1, 장바구니"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, 레벨1, 배포"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, 레벨2, 자동차경주"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, 레벨2, 숫자야구게임"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, 레벨4, 로또"));
		assertThrows(IllegalArgumentException.class, () -> DomainValidator.validateInputForm("프론트엔드, 레벨4, 지하철노선도"));

	}

}
