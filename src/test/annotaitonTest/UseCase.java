package test.annotaitonTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 1.�������η�����Ϊpublic����дĬ��Ϊpublic��
 * 2.��Ԫ�ص�����ֻ���ǻ����������͡�String��Class��ö�����͡�ע�����ͣ�������ע���Ƕ��Ч�����Լ��������͵�һλ���飻
 * 3.��Ԫ�ص�����һ�㶨��Ϊ���ʣ����ע����ֻ��һ��Ԫ�أ����������Ϊvalue������ʹ�û����������������
 * 4.()���Ƕ��巽�������ĵط���Ҳ�����������ж����κβ���������ֻ��һ��������﷨��
 * 5.default����Ĭ��ֵ��ֵ����͵�2�㶨�������һ�£�
 * 6.���û��Ĭ��ֵ���������ʹ��ע��ʱ�����������Ԫ�ظ�ֵ��
 * 
 * @Target:�޶�ע��ʹ�÷�Χ
 * 		TYPE,
 *		FIELD,
 * 		METHOD,
 * 		PARAMETER,
 * 		CONSTRUCTOR,
 * 		LOCAL_VARIABLE,
 * 		ANNOTATION_TYPE,
 * 		PACKAGE
 * @Retention
 * 		RetentionPolicy.SOURCE,
 * 		RetentionPolicy.CLASS(default),
 * 		RetentionPolicy.RUNTIME
 * @Documented
 * 		�Ƿ����ɵ�JavaDoc�ĵ�����
 * @Inherited
 * 		�ɼ̳е����ࡣֻ��ElementType.TYPE��Ч��
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface UseCase{
	public int id() default -1;
	public String description() default "";
}