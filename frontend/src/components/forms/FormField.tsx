import React from 'react';

interface FormFieldProps extends React.InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  error?: string;
  helperText?: string;
}

export const FormField = ({ label, error, helperText, ...props }: FormFieldProps) => {
  return (
    /* flex-col para que el label esté arriba, pero con un max-w para que no ocupe todo el ancho */
    <div className="flex flex-col gap-1.5 w-full max-w-sm mb-4">
      {label && (
        <label
          className="text-sm font-semibold text-gray-700 ml-0.5"
        >
          {label}
        </label>
      )}

      <input
        {...props}
        className={`
          px-3 py-2 text-sm border rounded-md outline-none transition-all duration-200
          placeholder:text-gray-400
          ${error
            ? 'border-red-500 focus:ring-4 focus:ring-red-100'
            : 'border-gray-300 focus:border-green-500 focus:ring-4 focus:ring-green-50/50 shadow-sm'
          }
        `}
      />

      {/* Mensajes de error o ayuda en la misma línea para ahorrar espacio */}
      {error && (
        <span className="text-[11px] text-red-500 font-medium ml-0.5">
          {error}
        </span>
      )}

      {helperText && !error && (
        <span className="text-[11px] text-gray-400 ml-0.5">
          {helperText}
        </span>
      )}
    </div>
  );
};